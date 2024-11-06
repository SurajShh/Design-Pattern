Proxy Pattern

Use Case: Implementing a proxy for accessing a large image file in a document viewer application, where loading the full image is costly.

Explanation: The Proxy pattern provides a placeholder object that controls access to another object. A ProxyImage class can load the actual image only when it's needed (e.g., on-demand loading).
