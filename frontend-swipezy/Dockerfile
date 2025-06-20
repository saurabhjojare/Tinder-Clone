FROM node:24-alpine

# Set working directory
WORKDIR /app

# Install latest npm and dependencies
COPY package*.json ./
RUN npm install -g npm@11.4.2 && npm install

# Copy app code
COPY . .

# Default Vite port (can be overridden per service)
EXPOSE 5173

# Start the app (can be overridden by Compose)
CMD ["npm", "run", "dev"]
