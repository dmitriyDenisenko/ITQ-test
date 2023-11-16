<template>
    <div>
        <h1>ITQ test</h1>
        <div class="choose">
            <button @click="showOrders">Заказы</button>
            <button @click="showDetails">Детали заказов</button>
        </div>

        <div v-show="mode">
            <h1>Заказы</h1>
            <table>
                <thead>
                <tr>
                    <th>ID заказа</th>
                    <th>Имя заказчика</th>
                    <th>Адрес заказчика</th>
                    <th>Общая сумма заказа</th>
                    <th>Дата создания</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="orders in data" :key="orders.id">
                    <td>{{ orders.id }}</td>
                    <td>{{ orders.customerName }}</td>
                    <td>{{ orders.customerAddress }}</td>
                    <td>{{ orders.totalCount }}</td>
                    <td>{{ orders.date }}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div v-show="!mode">
            <h1>Детали заказа</h1>
            <table>
                <thead>
                <tr>
                    <th>ID заказа</th>
                    <th>Номер продукта</th>
                    <th>Название продукта</th>
                    <th>Количество продукта</th>
                    <th>ID заказа</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="detail in data" :key="detail.id">
                    <td>{{ detail.id }}</td>
                    <td>{{ detail.productNumber }}</td>
                    <td>{{ detail.productName }}</td>
                    <td>{{ detail.productCount }}</td>
                    <td v-if="detail.order && detail.order.id">{{ detail.order.id}}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div id="pagination">
            <button @click="prevPage" :disabled="pagination === 0">Previous</button>
            <span>Page {{pagination + 1}} of {{countPages}}</span>
            <button @click="nextPage" :disabled="pagination === countPages - 1">Next</button>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const pagination = ref(0);
const countPages = ref(0);
const mode = ref(true);
const data = ref([]);

const showOrders = () => {
    pagination.value = 0;
    mode.value = true;
    fetchData();
};

const showDetails = () => {
    pagination.value = 0;
    mode.value = false;
    fetchData();
};

const nextPage = () => {
    if (pagination.value < countPages.value - 1) {
        pagination.value += 1;
        fetchData();
    }
};

const prevPage = () => {
    if (pagination.value > 0) {
        pagination.value -= 1;
        fetchData();
    }
};

const fetchData = async () => {
    try {
        let response;
        if (mode.value) {
            response = await axios.get(`http://localhost:8080/orders?offset=${pagination.value}`);
        } else {
            response = await axios.get(`http://localhost:8080/details?offset=${pagination.value}`);
            console.log(response.data)
        }

        data.value = response.data.content;
        countPages.value = response.data.totalPages;
    } catch (error) {
        console.error('Error fetching data:', error);
    }
};
onMounted(fetchData);
</script>


<style scoped>
.choose {
    display: flex;
    justify-content: center;
}
button {
    padding: 10px 20px;
    font-size: 16px;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border: 2px solid #3498db;
    border-radius: 5px;
    color: #3498db;
    background-color: #fff;
    transition: background-color 0.3s, color 0.3s;
}

/* При наведении добавляем немного тени и меняем цвет фона и текста */
button:hover {
    background-color: #3498db;
    color: #fff;
    box-shadow: 0 0 10px rgba(52, 152, 219, 0.5);
}
h1 {
    text-align: center;
}
table {
    border-collapse: collapse;
    width: 100%;
}

th,
td {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

th {
    background-color: #f2f2f2;
}
#pagination {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 20px;
}

#pagination button {
    padding: 8px 12px;
    font-size: 14px;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border: 2px solid #3498db;
    border-radius: 4px;
    color: #3498db;
    background-color: #fff;
    transition: background-color 0.3s, color 0.3s;
}

#pagination button:disabled {
    cursor: not-allowed;
    opacity: 0.6;
}

#pagination button:hover:not(:disabled) {
    background-color: #3498db;
    color: #fff;
}
</style>
