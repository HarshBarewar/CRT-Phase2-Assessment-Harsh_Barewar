function UserList() {
    const [users, setUsers]     = useState([]);
    const [loading, setLoading] = useState(true);   // (c) loading state

    useEffect(() => {                               // (b) FIXED — add []
        fetch('/api/users')
            .then(res => res.json())
            .then(data => {
                setUsers(data);
                setLoading(false);                  // done loading
            });
    }, []);                                         // <-- empty array = run once

    if (loading) return <p>Loading...</p>;         // (c) show while fetching

    return (
        <ul>
            {users.map(u => <li key={u.id}>{u.name}</li>)}
        </ul>
    );
}