import React from "react";
import Project from "../Project/Project";
import "./Projects.css";
import type ProjectsData from "../../data/ProjectsData";

type Props = {
  projects: ProjectsData;
};

const Projects = (props: Props) => {
  var { projects } = props;
  return (
    <div className="container">
      <div className="row">
        {projects.projects.map((element, index) => (
          <Project key={index} project={element} />
        ))}
      </div>
    </div>
  );
};

export default Projects;
