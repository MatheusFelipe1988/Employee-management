import React, { useEffect, useState } from "react";
import {
  createEmployee,
  getEmployee,
  updateEmployee,
} from "../service/EmployeeService";
import { useNavigate, useParams } from "react-router-dom";

const EmployeeComponent = () => {
  const [firstName, setFistName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const { id } = useParams();

  const [erros, setErros] = useState({
    firstName: "",
    lastName: "",
    email: "",
  });

  const navigator = useNavigate();

  useEffect(() => {
    if (id) {
      getEmployee(id)
        .then((response) => {
          setFistName(response.data.firstName);
          setLastName(response.data.lastName);
          setEmail(response.data.email);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  function saveOrUpdateEmployee(e) {
    e.preventDefault();

    if (validateForm()) {
      const employee = { firstName, lastName, email };
      console.log(employee);

      if (id) {
        updateEmployee(id, employee)
          .then((response) => {
            console.log(response.data);
            navigator("/employee");
          })
          .catch((error) => {
            console.error(error);
          });
      } else {
        createEmployee(employee)
          .then((response) => {
            console.log(response.data);
            navigator("/employee");
          })
          .catch((error) => {
            console.error(error);
          });
      }
    }
  }

  function validateForm() {
    let valid = true;

    const errosCopy = { ...erros };

    if (firstName.trim()) {
      errosCopy.firstName = "";
    } else {
      errosCopy.firstName = "first name is required";
      valid = false;
    }

    if (lastName.trim()) {
      errosCopy.lastName = "";
    } else {
      errosCopy.lastName = "last name is required";
      valid = false;
    }

    if (email.trim()) {
      errosCopy.email = "";
    } else {
      errosCopy.email = "email is required";
    }

    setErros(errosCopy);

    return valid;
  }

  function pageTitle() {
    if (id) {
      return <h2 className="text-center">Update Employee</h2>;
    } else {
      return <h2 className="text-center">Add Employee</h2>;
    }
  }

  return (
    <div className="container">
      <br /> <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          {pageTitle()}
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">First Name!</label>
                <input
                  type="text"
                  placeholder="Enter Employee First Name"
                  name="firstName"
                  value={firstName}
                  className={`form-control ${
                    erros.firstName ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setFistName(e.target.value)}
                ></input>
                {erros.firstName && (
                  <div className="invalid-feedback"> {erros.firstName} </div>
                )}
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Last Name!</label>
                <input
                  type="text"
                  placeholder="Enter Employee Last Name"
                  name="lastName"
                  value={lastName}
                  className={`form-control ${
                    erros.lastName ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setLastName(e.target.value)}
                ></input>
                {erros.lastName && (
                  <div className="invalid-feedback"> {erros.lastName} </div>
                )}
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Email!</label>
                <input
                  type="text"
                  placeholder="Enter Employee email"
                  name="email"
                  value={email}
                  className={`form-control ${erros.email ? "is-invalid" : ""}`}
                  onChange={(e) => setEmail(e.target.value)}
                ></input>
                {erros.email && (
                  <div className="invalid-feedback"> {erros.email} </div>
                )}
              </div>

              <button
                className="btn btn-success"
                onClick={saveOrUpdateEmployee}
              >
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmployeeComponent;
