第二周 Git 

1. 工作区、暂存区、本地仓库、远程仓库

工作区：平时直接编辑文件的地方
暂存区：使用 git add 后，文件先进入暂存区 
本地仓库：本机上的 Git 仓库，使用 git commit 后保存到这里
远程仓库：GitHub 上的仓库，用于备份和共享代码

 2. 常用 Git 命令

git clone
作用：把远程仓库复制到本地

 git add
作用：把工作区修改添加到暂存区

git commit
作用：把暂存区内容提交到本地仓库

git push
作用：把本地仓库内容推送到远程仓库

git pull
作用：拉取远程仓库最新内容到本地

git branch
作用：查看或创建分支

git checkout
作用：切换分支

git merge
作用：合并分支

git status
作用：查看当前仓库状态

git log
作用：查看提交历史

git diff
作用：查看文件差异

 3. .gitignore 的作用

.gitignore 用来告诉 Git 哪些文件不需要提交到仓库，例如：
编译生成的文件
临时文件
IDE 配置文件

