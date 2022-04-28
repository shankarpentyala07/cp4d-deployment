#!/usr/bin/env groovy

def gv

pipeline {
    agent any

        parameters {
        string(name: 'region', defaultValue: 'us-west-2', description: 'The region to deploy the cluster in, e.g: us-west-2.')
        string(name: 'az', defaultValue: 'single_zone', description: 'single_zone / multi_zone')
        string(name: 'availability_zone1', defaultValue: 'us-west-2a', description: 'example us-west-2a')
        string(name: 'availability_zone2', defaultValue: 'us-west-2b', description: 'example us-west-2b')
        string(name: 'availability_zone3', defaultValue: 'us-west-2c', description: 'example us-west-2c')
        password (name: 'AWS_ACCESS_KEY_ID')
        password (name: 'AWS_SECRET_ACCESS_KEY')
        string(name: 'base_domain', defaultValue: 'cpdonawsonline.com', description: 'Route 53 domain')
        string(name: 'cluster_name', defaultValue: 'cpd-test', description: 'Cluster Name')
        string(name: 'worker_replica_count', defaultValue: '6', description: 'No of worker nodes')
        string(name: 'openshift_pull_secret_file_path', defaultValue: '/var/lib/jenkins/workspace/selfmanaged-openshift/pull-secret.txt', description: 'Openshift pull secret file path')
        string(name: 'openshift_username', defaultValue: 'ocadmin', description: 'Openshift Username')
        string(name: 'openshift_password', defaultValue: 'password', description: 'Openshft Password')
        string(name: 'cpd_api_key', defaultValue: '', description: 'Repository APIKey or Registry password')
        string(name: 'cpd_external_registry', defaultValue: 'cp.icr.io', description: 'URL to external registry for CPD install. Note: CPD images must already exist in the repo')
        string(name: 'cpd_external_username', defaultValue: 'cp', description: 'URL to external username for CPD install. Note: CPD images must already exist in the repo')
        choice(name: 'accept_cpd_license', choices: ['accept','reject'], description: 'Read and accept license at https://www14.software.ibm.com/cgi-bin/weblap/lap.pl?li_formnum=L-DNAA-BZTPEW, (accept / reject)')
        string(name: 'public_ssh_key', defaultValue: '', description: 'Public SSH key value')
        choice(name: 'watson_knowledge_catalog', choices: ['no','yes'], description: 'Install Watson Knowledge catalog(yes/ no)')        
        booleanParam(name: 'autoApprove', defaultValue: false, description: 'Automatically run apply after generating plan?')
    }

    environment {
                access_key_id     = "${params.AWS_ACCESS_KEY_ID}"
                secret_access_key = "${params.AWS_SECRET_ACCESS_KEY}"
    }
    stages {
        stage('fetch_latest_code') {
          steps {
                git credentialsId: 'github', url: 'https://github.com/IBM/cp4d-deployment'    
            }
        }
        stage('Initalize') {
            steps {
               script {
                   gv = load "script.groovy"
                   gv.tfInitalize()
               }
            }
        }
        stage('Plan') {
            steps {
               script {
                  gv.tfPlan()
               }
            }
        }
        stage('Apply') {
            steps {
               script {
                   gv.tfApply()
               }
            }
        }
        stage('Destroy') {
            steps {
               script {
                   gv.tfDestroy()
               }
            }
        }
    }
}

