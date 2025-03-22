import { EducationProgram } from "./EducationProgram.js";
import { EducationManager } from "./EducationMananger.js";

const manager = new EducationManager();

const program1 = new EducationProgram('기초 펫 돌봄', '기초적인 펫 돌봄 방법을 배웁니다.');
const program2 = new EducationProgram('건강관리', '펫의 건강을 유지하는 방법을 배웁니다.');

manager.registerProgram(program1);
manager.registerProgram(program2);

manager.completeProgramWithFuction('기초 펫 돌봄');

manager.completeProgramWithArrowFunction('건강관리');

await manager.saveToFile();