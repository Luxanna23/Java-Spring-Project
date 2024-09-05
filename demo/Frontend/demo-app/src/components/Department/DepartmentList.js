import axios from 'axios';
import { useEffect, useState } from 'react';

function DepartmentList() {
  const [department, setDepartment] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/departments')
      .then(response => setDepartment(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div className="container">
      <h2>Departement Liste</h2>
      <table>
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>

        <tbody>
          {department.map(dep => (
            <tr key={dep.id}>
              <td>{dep.id}</td>
              <td>{dep.name}</td>
              <td>{dep.description}</td>
              {/* <td><button onClick={() => updateDepartment(dep.id)}>Update</button></td>
              <td><button onClick={() => deleteDepartment(dep.id)}>Delete</button></td> */}
              <td>
                <button>Update</button>
                <button>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default DepartmentList;
