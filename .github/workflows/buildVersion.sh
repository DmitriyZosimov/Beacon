#!/bin/bash

git config --local user.name "GitHub Actions"
git config --local user.email actions@github.com

git pull

LAST_TAG=$(git describe --match "*" --abbrev=0 --tags)
echo "The latest tag version: $LAST_TAG"
LAST_BUILD_VERSION=$LAST_TAG

if [ "$LAST_BUILD_VERSION" = "" ]; then
  NEXT_BUILD_VERSION="0.0.1"
  echo "There are currently no tag version. Tagging commit with version $NEXT_BUILD_VERSION"
  git tag -d "$NEXT_BUILD_VERSION" || true
  git tag "$NEXT_BUILD_VERSION" || {
    echo "ERROR: Tagging commit failed"
    exit 1
  }
  git push origin --tags || {
    echo "ERROR: Pushing tags failed"
    exit 1
 }
 echo "Finished creating initial tag version: $NEXT_BUILD_VERSION"
 echo "$NEXT_BUILD_VERSION" >./buildVersion.txt
 exit 0
fi

echo "The latest build version is $LAST_BUILD_VERSION"
SECOND_TAG_NUMBER=$(echo "$LAST_BUILD_VERSION" | cut -d. -f2)
SECOND_FILE_NUMBER=$(cat ./buildVersion.txt | cut -d. -f2)

if [ "$SECOND_TAG_NUMBER" = "$SECOND_FILE_NUMBER" ];
then
  BUILD_NUMBER=$(echo "$LAST_BUILD_VERSION" | cut -d. -f3)
  NEXT_BUILD_VERSION=$(cat ./buildVersion.txt | cut -d. -f1-2).$((BUILD_NUMBER + 1))
else
  NEXT_BUILD_VERSION=$(cat ./buildVersion.txt | cut -d. -f1-2).0
fi

echo "The next build version is $NEXT_BUILD_VERSION"
git tag -d "$NEXT_BUILD_VERSION" || true
echo "$NEXT_BUILD_VERSION" >./buildVersion.txt

git tag "$NEXT_BUILD_VERSION" || {
  echo "ERROR: Tagging commit failed"
  exit 1
}

git push --tags || {
  echo "ERROR: Publishing tags failed"
}

git add -A
git commit -m "version $NEXT_BUILD_VERSION"

git push || {
  echo "ERROR: Pushing the new version failed"
  exit 1
}

exit 0