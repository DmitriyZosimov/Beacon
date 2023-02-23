#!/bin/bash

if [ "$TOKEN" = "" ]; then
  echo "The token is not available, can not set build version"
  exit 1
fi
git config --local user.name "GitHub Actions"
git config --local user.email actions@github.com

GITHUB_URL="https://$TOKEN@github.com/DmitriyZosimov/Beacon.git"
git remote set-url origin "$GITHUB_URL"
git remote -v

git fetch origin

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
 echo "$NEXT_BUILD_VERSION" >.github/workflows/buildVersion.txt
 exit 0
fi
echo "The latest build version is $LAST_BUILD_VERSION"
SECOND_TAG_NUMBER=$(echo "$LAST_BUILD_VERSION" | cut -d. -f2)
SECOND_FILE_NUMBER=$(cat .github/workflows/buildVersion.txt | cut -d. -f2)
if [ "$SECOND_TAG_NUMBER" = "$SECOND_FILE_NUMBER" ];
then
  BUILD_NUMBER=$(echo "$LAST_BUILD_VERSION" | cut -d. -f3)
  NEXT_BUILD_VERSION=$(cat .github/workflows/buildVersion.txt | cut -d. -f1-2).$((BUILD_NUMBER + 1))
else
  NEXT_BUILD_VERSION=$(cat .github/workflows/buildVersion.txt | cut -d. -f1-2).0
fi

echo "The next build version is $NEXT_BUILD_VERSION"
git tag -d "$NEXT_BUILD_VERSION" || true
echo "$NEXT_BUILD_VERSION" >.github/workflows/buildVersion.txt
git add .github/workflows/buildVersion.txt
git commit -m "version $NEXT_BUILD_VERSION"
git tag "$NEXT_BUILD_VERSION" || {
  echo "ERROR: Tagging commit failed"
  exit 1
}
git push -u origin refs/heads/master:master || {
  echo "ERROR: Pushing tags failed"
  exit 1
}

exit 0

