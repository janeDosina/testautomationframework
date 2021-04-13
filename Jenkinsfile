pipeline {
	agent any
	stages {
		stage("run gradle test") {
			steps {
				echo 'executing gradle ...'
				withGradle() {
					sh './gradlew test'
				}
			}
		}
	}
}