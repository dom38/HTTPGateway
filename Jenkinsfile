#!/usr/bin/env groovy

pipeline {
    agent { docker 'maven:3.3.3' }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
    
    post {
    
        success {
        
            echo "This all worked!"
        
        }
        
        always {
       
            echo "Going"
            
        }
    
    }
    
}
