import axios from 'axios';
import { useEffect, useState } from 'react';

function DepartementList() {
  const [departement, setDepartement] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/departement')
      .then(response => setDepartement(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div className="container">
      <h2>Departement Liste</h2>
      <ul>
        {departement.map( dep => (
          <li key={dep.id}>{dep.name} {dep.description}</li>
        ))}
      </ul>
    </div>
  );
}

export default DepartementList;