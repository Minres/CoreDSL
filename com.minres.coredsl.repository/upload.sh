#!/bin/bash
##

cd target/repository

baseurls="https://artifactory.minres.com/artifactory/test-repo/CoreDSL/2.0  https://artifactory.minres.com/artifactory/test-repo/CoreDSL/latest"
file_list=`find . -type f | grep -v p2.index`

for artifact_name in $file_list; do
  for URL in $BASEURLS; do
    sha256=$(openssl dgst -sha256 ${artifact_name}|sed 's/^SHA256.*= //')
    sha1=$(openssl dgst -sha1 ${artifact_name}|sed 's/^SHA.*= //')
    md5=$(openssl dgst -md5 ${artifact_name}|sed 's/^MD5.*= //')
  	# Upload artifact to artifactory
  	curl -sSf -u${USERNAME}:${PASSWORD} -T ${artifact_name} \
  	  -H "X-Checksum-Sha256:${sha256}" \
  	  -H "X-Checksum-Sha1:${sha1}" \
  	  -H "X-Checksum-md5:${md5}" \
  	  $URL/$f > /dev/null
  done
done

