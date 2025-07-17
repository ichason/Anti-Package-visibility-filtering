#!/bin/bash

# 获取当前提交次数
COMMIT_COUNT=$(git rev-list --count HEAD)
COMMIT_HASH=$(git rev-parse --short HEAD)

echo "准备提交 - 构建号: $COMMIT_COUNT, 提交哈希: $COMMIT_HASH"

# 更新build.gradle.kts中的版本号
sed -i "s/versionCode = [0-9]*/versionCode = $COMMIT_COUNT/" app/build.gradle.kts
sed -i "s/versionName = \"[^\"]*\"/versionName = \"1.0.$COMMIT_COUNT-$COMMIT_HASH\"/" app/build.gradle.kts

echo "版本号已更新为: 1.0.$COMMIT_COUNT-$COMMIT_HASH"

# 添加修改后的文件到暂存区
git add app/build.gradle.kts

echo "版本文件已添加到暂存区" 