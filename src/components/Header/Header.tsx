import { faGithub } from "@fortawesome/free-brands-svg-icons";
import { faInfoCircle } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React from "react";
import "./Header.css";

const Header = () => (
  <nav className="navbar navbar-expand-sm navbar-light bg-light">
    <a className="ms-4 navbar-brand" href="#">
      My Portfolio
    </a>
    <button
      className="navbar-toggler me-2"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarText"
      aria-controls="navbarText"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="w-100"></div>
    <div
      className="ms-4 me-2 collapse navbar-collapse text-end"
      id="navbarText"
    >
      <ul className="navbar-nav mr-auto text-start">
        <li className="nav-item">
          <a
            title="repository"
            className="nav-link d-inline-flex align-items-center"
            aria-current="page"
            href="https://github.com/jorgeamadosoria/portfolio"
          >
            <FontAwesomeIcon size={"2x"} icon={faGithub} />
            &nbsp;&nbsp;Repository
          </a>
        </li>
        <li className="nav-item">
          <a
            title="Résumé"
            className="nav-link d-inline-flex align-items-center"
            href="https://jorgeamadosoria.info"
          >
            <FontAwesomeIcon size={"2x"} icon={faInfoCircle} />
            &nbsp;&nbsp; Author
          </a>
        </li>
      </ul>
    </div>
  </nav>
);

export default Header;
