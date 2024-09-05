import axios from 'axios';
import { useEffect, useState } from 'react';

function EmployeeList() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/employees')
      .then(response => setEmployees(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div className="container">
      <h2>Employee Liste</h2>
      <table>
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">First name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Id Department</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>

        <tbody>
          {employees.map(employee => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
              <td>{employee.department_id}</td>
              {/* <td><button onClick={() => updateEmployee(employee.id)}>Update</button></td>
              <td><button onClick={() => deleteEmployee(employee.id)}>Delete</button></td> */}
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

export default EmployeeList;