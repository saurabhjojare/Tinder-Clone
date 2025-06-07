#!/bin/bash

set -e

echo "Updating system packages..."
sudo apt update && sudo apt upgrade -y

echo "Installing prerequisites..."
sudo apt install -y apt-transport-https ca-certificates curl software-properties-common gnupg lsb-release

echo "Installing Docker..."

# Add Docker's official GPG key
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

# Add Docker repo
echo \
  "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

sudo apt update

sudo apt install -y docker-ce docker-ce-cli containerd.io

echo "Starting Docker service..."
sudo systemctl start docker
sudo systemctl enable docker

echo "Adding current user to docker group..."
sudo usermod -aG docker $USER

echo "Pulling MongoDB 5.0.26 Docker image..."
docker pull mongodb/mongodb-community-server:5.0.26-ubuntu2004

echo "Running MongoDB container..."
docker run --name mongodb -p 27017:27017 -d mongodb/mongodb-community-server:5.0.26-ubuntu2004

echo "Installing MongoDB Shell (mongosh)..."

# Download MongoDB public key
curl -fsSL https://pgp.mongodb.com/server-6.0.asc -o server-6.0.asc

# Convert key
gpg --dearmor server-6.0.asc

# Move key to system directory (requires sudo)
sudo mv server-6.0.asc.gpg /usr/share/keyrings/mongodb-server-6.0.gpg

# Add MongoDB repo
echo "deb [ signed-by=/usr/share/keyrings/mongodb-server-6.0.gpg ] https://repo.mongodb.org/apt/ubuntu focal/mongodb-org/6.0 multiverse" | \
  sudo tee /etc/apt/sources.list.d/mongodb-org-6.0.list > /dev/null

sudo apt update

sudo apt install -y mongodb-mongosh

echo "Setup complete! To use MongoDB shell, you may need to log out and back in for Docker group permissions to take effect."

echo "Connect to MongoDB with:"
echo "mongosh --port 27017"

echo "You can check Docker container status with:"
echo "docker ps"

