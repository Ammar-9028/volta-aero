pipeline {
    agent any

    tools {
        jdk 'Java21'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Ammar-9028/volta-aero.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Archive WAR') {
            steps {
                archiveArtifacts artifacts: 'target/volta-aero.war',
                    fingerprint: true
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                sshagent(credentials: ['tomcat-ssh']) {
                    sh '''
                        set -e
                        mkdir -p ~/.ssh
                        ssh-keyscan -H 3.145.5.70 >> ~/.ssh/known_hosts

                        scp target/volta-aero.war ubuntu@3.145.5.70:/home/ubuntu/volta-aero.war

                        ssh ubuntu@3.145.5.70 '
                            set -e
                            sudo -n chown ubuntu:ubuntu /home/ubuntu/tomcat/webapps
                            cd /home/ubuntu/tomcat/webapps
                            if [ -d ROOT ]; then
                                mv ROOT ROOT-backup-$(date +%Y%m%d%H%M%S)
                            fi
                            rm -f ROOT.war
                            mv /home/ubuntu/volta-aero.war ROOT.war
                        '
                    '''
                }
            }
        }
    }
}
