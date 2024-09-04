import React, { useState, useEffect } from 'react';
import axios from 'axios';
import EmployeeList from '../components/Employee/EmployeeList';
import EmployeeForm from '../components/Employee/EmployeeCreate';

function EmployeePage() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/employees')
      .then(response => setEmployees(response.data))
      .catch(error => console.error(error));
  }, []);

  const addEmployee = (employee) => {
    setEmployees([...employees, employee]);
  };

  const updateEmployee = (id) => {
    setEmployees([...employees, employees.filter((employee) => employee.id == id)]);//??????????????????????????????????????????????????
  };

  const deleteEmployee = (id) => {
    setEmployees(employees.filter((employee) => employee.id !== id));
  };

  return (
    <div className="container">
      <h1>Employees</h1>
      <section>
        <EmployeeForm addEmployee={addEmployee} />
      </section>
      <section>
        <EmployeeForm updateEmployee={updateEmployee} />
      </section>
      <section>
        <EmployeeList employees={employees} deleteEmployee={deleteEmployee} />
      </section>
    </div>
  );
}

export default EmployeePage;