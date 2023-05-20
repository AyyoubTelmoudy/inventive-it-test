pipeline {
	agent any

	environment {
		mavenHome = tool 'maven-3.6.3'
	}

	tools {
		jdk 'java 11'
	}

	stages {

		stage('Build'){
			steps {
				bat "mvn clean install -DskipTests"
			}
		}

		stage('Test'){
			steps{
				bat "mvn test"
			}
		}
		stage('Dockerize'){
            steps {
                  script {
                        docker.build("dream-case:${env.BUILD_NUMBER}", "-f Dockerfile .")
                        docker.image("dream-case:${env.BUILD_NUMBER}").run("-p 8088:8088")
                         }
                  }
        }
	}
}
