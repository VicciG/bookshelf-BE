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

resource "aws_db_instance" "bookshelf_db" {
  allocated_storage    = 100
  db_subnet_group_name = "db-subnetgrp"
  engine               = "postgres"
  engine_version       = "11.5"
  identifier           = "muffy-test"
  instance_class       = "db.m5.large"
  password             = "password"
  skip_final_snapshot  = true
  storage_encrypted    = true
  username             = "postgres"
}

output "ip" {
  value = aws_eip.ip.public_ip
}
