# Volta Aero – Automated CI/CD Pipeline

## Project Overview
This project demonstrates a CI/CD workflow for building and deploying a Java web application using Jenkins, Maven, GitHub Webhooks, AWS EC2, and Apache Tomcat.

The pipeline automatically checks out source code, builds the application, archives the WAR artifact, and deploys it to a Tomcat server. GitHub Webhooks trigger Jenkins when changes are pushed to the repository.

## Technologies Used
- AWS EC2
- Jenkins
- Git and GitHub
- GitHub Webhooks
- Java
- Apache Maven
- Apache Tomcat
- Linux
- SSH

## CI/CD Workflow
1. Developer commits changes to GitHub.
2. GitHub Webhook triggers Jenkins.
3. Jenkins checks out the source code.
4. Maven builds the Java application.
5. Jenkins archives the generated WAR file.
6. Jenkins connects to the Tomcat server using SSH.
7. The WAR file is deployed to Apache Tomcat.
8. The application is verified in a web browser.

## Pipeline Stages
- Checkout
- Build
- Archive WAR
- Deploy to Tomcat

## Key Learnings
- Configuring Jenkins pipelines using a Jenkinsfile.
- Automating Maven builds.
- Integrating GitHub Webhooks with Jenkins.
- Managing SSH credentials in Jenkins.
- Deploying WAR applications to Apache Tomcat.
- Working with AWS EC2 and Linux servers.

## Application
The application is deployed on an Apache Tomcat server hosted on AWS EC2.

## Repository
GitHub: https://github.com/Ammar-9028/volta-aero

## Author
Mohammed Ammar

Aspiring AWS DevOps Engineer | Cloud, Linux & Network Administration

---
This project was created for hands-on learning and practical DevOps experience.
