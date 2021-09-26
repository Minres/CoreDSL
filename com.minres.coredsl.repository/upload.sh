#!/bin/bash
##

[ -f $HOME/.upload.sh.cfg ] && . $HOME/.upload.sh.cfg


cd target/repository
artifactory_url='https://artifactory.minres.com/artifactory'
repo_module='eclipse/CoreDSL'
baseurls="h/test-repo/CoreDSL/$1  https://artifactory.minres.com/artifactory/test-repo/CoreDSL/latest"
file_list=`find . -type f | grep -v p2.index`

echo Uploading P2 artifacts to ${artifactory_url}/${repo_module}/${1}

for artifact_name in $file_list; do
  echo Processing $artifact_name
  for version in $1 latest; do
    sha256=$(openssl dgst -sha256 ${artifact_name}|sed 's/^SHA256.*= //')
    sha1=$(openssl dgst -sha1 ${artifact_name}|sed 's/^SHA.*= //')
    md5=$(openssl dgst -md5 ${artifact_name}|sed 's/^MD5.*= //')
  	# Upload artifact to artifactory
  	curl -sSf -u${USERNAME}:${PASSWORD} -T ${artifact_name} \
  	  -H "X-Checksum-Sha256:${sha256}" \
  	  -H "X-Checksum-Sha1:${sha1}" \
  	  -H "X-Checksum-md5:${md5}" \
  	  ${artifactory_url}/${repo_module}/${version}/$f > /dev/null
  done
done

