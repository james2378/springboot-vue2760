const base = {
    get() {
        return {
            url : "http://localhost:8080/shiwuzizhuzhinanfuwu/",
            name: "shiwuzizhuzhinanfuwu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shiwuzizhuzhinanfuwu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园事务自助指南服务系统"
        } 
    }
}
export default base
