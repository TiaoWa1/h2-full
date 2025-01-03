import axios from 'axios';

const PRODUCT_API_URL = "http://localhost:8080/api/products"; // 會呼叫 JAVA SPRING BOOT 中的 Controller 與其中的函數
class ProductService {
    getProducts() {
        return axios.get(PRODUCT_API_URL);
    }

    getProductById(productId) {
        return axios.get(`${PRODUCT_API_URL}/${productId}`);
    }

    deleteProduct(productId) {
        return axios.delete(`${PRODUCT_API_URL}/${productId}`);
    }

    createProduct(product) {
        return axios.post(PRODUCT_API_URL, product);
    }

    updateProduct(product, productId) {
        return axios.put(`${PRODUCT_API_URL}/${productId}`, product);
    }
}

export default new ProductService();