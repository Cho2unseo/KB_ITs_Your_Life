import { menu } from "./menu.js";
import { filterMenuByPrice } from "./menuFilter.js";

async function showAffordalbeMenu(menus) {
    const response = await filterMenuByPrice(menus, 18000);
    console.log("✅ 선택 가능한 메뉴:");
    response.forEach(element => {
        console.log(`${element.name}: ${element.price}원`);
    });
}

showAffordalbeMenu(menu);