import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import HomePage from './pages/Employee';
import AboutPage from './pages/Departement';

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/employee" component={EmployeePage} />
        <Route path="/departement" component={DepartementPage} />
      </Switch>
    </Router>
  );
}

export default App;