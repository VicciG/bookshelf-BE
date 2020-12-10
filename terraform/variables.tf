 variable "region" {
  default = "eu-west-2"
}

variable "vpc_security_group_ids" {
    default = [ "sg-c1d165b8" ]
}

variable "subnet_id" {
    default = "subnet-35e98a4f"
}
variable "amis" {
    type = "map"
    default = {
        "eu-west-2" = "ami-03b34b662beb8aedf"
    }
}


 // s3, rds
 // check ec2 instance connection from local
 // check ami has correct version of java/tomcat
