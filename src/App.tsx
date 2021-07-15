import React, { useEffect, useState } from "react";
import Header from "./components/Header/Header";
import Projects from "./components/Projects/Projects";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import ProjectsData from "./data/ProjectsData";

function App() {
  const [projectsState, setProjectsState] = useState({
    projects: new ProjectsData(),
  });
  useEffect(() => {
    fetch("https://jorgeamadosoria.info/data-store/portfolio/projects.json")
      .then(function (response) {
        if (!response.ok) {
          throw Error(response.statusText);
        }

        return response.json();
      })
      .then((json) => {
        setProjectsState({
          projects: new ProjectsData(json),
        });
      })
      .catch(function (error) {
        console.log(error);
        return null;
      });
  }, []);
  return (
    <div className="App">
      <Header></Header>
      <Projects projects={projectsState.projects} />
    </div>
  );
}

export default App;
