import React, { useState, useEffect } from 'react';
import axios from 'axios';
import DepartmentList from '../components/Department/DepartmentList';
import DepartmentForm from '../components/Department/DepartmentCreate';

function DepartmentPage() {
  const [departments, setDepartments] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/departments')
      .then(response => setDepartments(response.data))
      .catch(error => console.error(error));
  }, []);

  const addDepartment = (department) => {
    setDepartments([...departments, department]);
  };

  const updateDepartment = (id) => {
    setDepartments([...departments, departments.filter((department) => department.id == id)]);//??????????????????????????????????????????????????
  };

  const deleteDepartment = (id) => {
    setDepartments(departments.filter((department) => department.id !== id));
  };

  return (
    <div className="container">
      <h1>Departments</h1>
      <section>
        <DepartmentForm addDepartment={addDepartment} />
      </section>
      <section>
        <DepartmentForm updateDepartment={updateDepartment} />
      </section>
      <section>
        <DepartmentList departments={departments} deleteDepartment={deleteDepartment} />
      </section>
    </div>
  );
}

export default DepartmentPage;