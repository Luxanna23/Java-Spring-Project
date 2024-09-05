import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import EmployeePage from './pages/EmployeePage';
import DepartmentPage from './pages/DepartmentPage';
import HomePage from './pages/HomePage';
import Navbar from './components/Navbar';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/employee" element={<EmployeePage />} />
        <Route path="/department" element={<DepartmentPage />} />
      </Routes>
    </Router>
  );
}

export default App;