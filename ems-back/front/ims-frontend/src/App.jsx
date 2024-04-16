import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import HeaderComponents from './components/HeaderComponents'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter, Routes, Route} from 'react-router-dom'
import EmployeeComponent from './components/EmployeeComponent'

function App() {

  return (
    <>
    <BrowserRouter>
      <HeaderComponents />
        <Routes>
          {/* //http://localhost:8080 */}
          <Route path='/' element = {<ListEmployeeComponent/>}></Route>
          {/* //http://localhost:8080/employee */}
          <Route path='/employee' element = {<ListEmployeeComponent/>}></Route>
          {/* //http://localhost:8080/add-employee */}
          <Route path='/add-employee' element = {<EmployeeComponent/>}></Route>
          {/* //http://localhost:8080/edit-employee */}
          <Route path='/edit-employee/:id' element = {<EmployeeComponent/>}></Route>
        </Routes>
      <FooterComponent />
    </BrowserRouter>
    </>
  )
}

export default App
