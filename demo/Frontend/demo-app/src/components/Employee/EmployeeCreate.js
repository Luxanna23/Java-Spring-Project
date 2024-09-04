import { useState } from 'react';
import axios from 'axios';

function EmployeeForm({ addEmployee }) {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const newEmployee = { firstName, lastName, email };

    axios.post('http://localhost:8080/api/employees', newEmployee)
      .then(response => {
        addEmployee(response.data); 
        setFirstName('');
        setLastName('');
        setEmail('');
      })
      .catch(error => console.error(error));
  };

  return (
    <form onSubmit={handleSubmit}>
      <span>Prenom</span>
      <input
        type="text"
        value={firstName}
        onChange={(e) => setFirstName(e.target.value)}
        required
      />
      <span>Nom</span>
      <input
        type="text"
        value={lastName}
        onChange={(e) => setLastName(e.target.value)}
        required
      />
      <span>Email</span>
      <input
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        required
      />
      <button type="submit">Ajouter</button>
    </form>
  );
}

export default EmployeeForm;