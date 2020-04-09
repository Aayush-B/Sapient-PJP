pipeline{
	agent any
	
	stages{
		stage('SCM Checkout'){
			steps{
				checkout scm
			}
			
		}

		stage('Build Step'){
			steps{
				script{
					def mvnHome = tool name: 'Maven', type: 'maven'
				}
				sh 'cd exampleApp'
				sh "${mvnHome}/bin/mvn clean package"
			}
		}

		stage('Executing JAR') {
			steps{
					sh 'java -jar target/exampleApp-1.0.jar'
				}
			}
			
		}
	}