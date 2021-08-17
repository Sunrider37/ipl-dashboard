import './App.css';
import { TeamPage } from './pages/TeamPage';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import { MatchPage } from './pages/MatchPage';

function App() {
  return (
    <div className="app">
      <Router>
        <Switch>
        <Route exact path="/teams/:teamName" >
      <TeamPage />
        </Route>
        <Route path="/teams/:teamName/matches/:year">
          <MatchPage />
        </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
