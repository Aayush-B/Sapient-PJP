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
				useMaven(maven : 'Maven') {
					sh 'cd exampleApp'
					sh 'mvn clean package'
				}
			}
		}

		stage('Executing JAR') {
			steps{
					useJAVA(java : 'JDK_8'){
					sh 'java -jar target/exampleApp-1.0.jar'
				}
			}
			
		}
	}
}