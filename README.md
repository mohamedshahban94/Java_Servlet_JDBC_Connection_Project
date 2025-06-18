# Java Servlet + JDBC Connection Project 

This repository contains a sample Java Servlet + JDBC Connection project created in Eclipse EE and pushed to GitHub using Git commands. Below are the step-by-step instructions for uploading and updating the project via Git.

---

## 🚀 Upload Project from Eclipse to GitHub

### ✅ Step 1: Locate Your Eclipse Project
Navigate to your Eclipse workspace directory.  
📁 Example path:  

Example path: S:\jee-workspace\StudentServlet

### ✅ Step 2: Open Terminal in Project Directory
Open Command Prompt S:\jee-workspace\StudentServlet

### ✅ Step 3: Initialize Git
git init

### ✅ Step 5: Add and Commit Files
git add .
git commit -m "Initial commit of Java EE project"

### ✅ Step 6: Create a New Repository on GitHub
Go to GitHub

Click "+" in top right → New repository

Enter: Repository name (same or different from Eclipse project name)
Leave README, .gitignore, etc. unchecked
Click Create repository

### ✅ Step 7: Link Local Project to GitHub Repo
You’ll see a GitHub page like:

git remote add origin https://github.com/mohamedshahban94/Java_Servlet_JDBC_Connection_Project.git

To verify:
git remote -v

### ✅Step 8: Push Your Project
Push the files from your local Git repo to GitHub:

git branch -M main
git push -u origin main

---
Steps to Update GitHub After Modifying Files in Eclipse
--- 
### ✅Step 1: Go to Your Project Directory
Open Git Bash or Command Prompt in your Eclipse project folder again:
cd "S:\jee-workspace\StudentServlet"

### ✅Step 2: Check What Changed

git status

### ✅Step 3: Stage the Changes
To stage all changes (added, modified, or deleted files):

git add .

### ✅Step 4: Commit the Changes

git commit -m "Updated logic in X file and added Y feature"

### ✅Step 5: Push to GitHub

git push origin main
