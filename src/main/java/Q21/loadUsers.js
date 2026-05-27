async function loadUsers() {
    try {
        const response = await fetch('/api/users');

        if (!response.ok) {
            throw new Error(`HTTP error: ${response.status}`);
        }

        const users = await response.json();
        const ul = document.getElementById('user-list');
        ul.innerHTML = '';                        // clear previous content

        users.forEach(user => {
            const li = document.createElement('li');
            li.textContent = user.name;
            ul.appendChild(li);
        });

    } catch (error) {
        const errorEl = document.getElementById('error');
        errorEl.textContent = `Failed to load users: ${error.message}`;
    }
}