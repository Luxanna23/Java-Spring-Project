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
      <ul>
        {employees.map(employee => (
          <li key={employee.id}> 
                {employee.firstName} {employee.lastName}
                {/* <button onClick={() => updateEmployee(employee.id)}>Update</button> */}
                {/* <button onClick={() => deleteEmployee(employee.id)}>Delete</button> */}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default EmployeeList;