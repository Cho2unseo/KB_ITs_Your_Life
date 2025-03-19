import { Customer } from "./Customer.js";
import { ConsultationManager } from "./ConsultationManager.js";

const manager = new ConsultationManager();

manager.registerConsultation(new Customer('홍길동', '010-1234-5678', '고양이'));
// console.log(manager);
manager.registerConsultation(new Customer('이몽룡', '123-4567-8901', '강아지'));
manager.registerConsultation(new Customer('홍길동', '010-1234-5678', '강아지'));

manager.autoEndConsulation();