pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkinstoken', url: 'https://github.com/prajwal-jagadeesh/my-java-webapp.git']])
            }
        }
    }
}
