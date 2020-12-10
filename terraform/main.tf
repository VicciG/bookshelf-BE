terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 2.70"
    }
  }
}

provider "aws" {
  profile = "default"
  region  = var.region
}

resource "aws_instance" "example" {
  ami           = var.amis[var.region]
  instance_type = "t2.micro"
  vpc_security_group_ids = var.vpc_security_group_ids
  subnet_id = var.subnet_id
}

resource "aws_eip" "ip" {
  vpc      = true
  instance = aws_instance.example.id
}

resource "aws_s3_bucket" "vicci_bookshelf_bucket" {
  bucket = "vicci-bookshelf"
  acl    = "private"

  tags = {
    Name          = "bookshelf"
    ApplicationId = "bookshelf"
  }
}

output "ip" {
  value = aws_eip.ip.public_ip
}
