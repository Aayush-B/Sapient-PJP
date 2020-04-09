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
					sh "cd exampleApp && ${mvnHome}/bin/mvn clean package"
				}
			}
		}

		stage('Executing JAR') {
			steps{
					sh 'cd exampleApp && java -jar target/exampleApp-1.0.jar'
				}
			}
			
		}
	}