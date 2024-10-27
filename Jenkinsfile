pipeline {
   agent any
   
   stages {
      stage('Build') {
         steps {
            echo 'Building stage'
            bat 'mvn clean'
            bat 'mvn compile'
            bat 'mvn package'
            
         }
      }
    stage('Deploy') {
         steps {
            echo 'Deploying stage'
         }
      }
     
   }
}