pipeline{
	stages{
		stage('SCM Checkout'){
			checkout scm
		}

		stage('Build Step'){
			useMaven(maven : 'Maven') {
				sh 'mvn clean package'
			}
		}

		stage('Executing JAR') {
			useJAVA(java : 'JDK_8'){
				sh 'java -jar target/exampleApp-1.0.jar'
			}
		}
	}
}