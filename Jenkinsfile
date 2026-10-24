pipeline {
    agent any
    options {
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }
    tools {
        jdk 'Java21'
        maven 'Maven3'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Verify Java and Maven') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -B clean test'
            }
        }
        stage('Package WAR') {
            steps {
                sh 'mvn -B package'
                archiveArtifacts artifacts: 'target/volta-aero.war', fingerprint: true
            }
        }
        stage('Deploy to Tomcat 9') {
            when { expression { return env.BRANCH_NAME == null || env.BRANCH_NAME == 'main' } }
            steps {
                echo 'Deployment is intentionally gated: configure the Tomcat host and safe copy permissions first.'
                echo 'Then replace this stage with your verified deployment command.'
            }
        }
    }
    post {
        success { echo 'Build successful — WAR is archived.' }
        failure { echo 'Build failed — open Console Output and inspect the first error.' }
        always { junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml' }
    }
}