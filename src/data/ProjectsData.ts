import ProjectData from "./ProjectData";

class ProjectsData {
  projects: [];
  constructor(json?: any) {
    this.projects= [];
    if (json) {
      this.projects = json.projects.map((p:any) => new ProjectData(p));
      this.sortProjectsByName();
    }
  }

  // sort projects by name
  sortProjectsByName(): void {
    this.projects = this.projects.sort((p1:ProjectData,p2:ProjectData) => p1.compare(p2));
  }
}


export default ProjectsData;