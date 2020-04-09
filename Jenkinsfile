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
				step('Define Maven Path'){
					def mvnHome = tool name: 'Maven', type: 'maven'
				}
				
				step('Build package'){
					sh 'cd exampleApp'
					sh "${mvnHome}/bin/mvn clean package"
				}
			}
		}

		stage('Executing JAR') {
			steps{
					step('Execute'){
						sh 'java -jar target/exampleApp-1.0.jar'
					}
					
				}
			}
			
		}
	}