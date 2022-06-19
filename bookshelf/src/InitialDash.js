import './InitialDash.css';
import Topbar from './components/TopBar/Topbar';
import SearchBar from './components/SearchBar/SearchBar';
import InitialBook from './components/InitialBookPage/InitialBook';
function InitialDash() {
  return (
    <div className="Dash">
      <Topbar />
      <InitialBook />
     
    </div>
  );
}

export default InitialDash;