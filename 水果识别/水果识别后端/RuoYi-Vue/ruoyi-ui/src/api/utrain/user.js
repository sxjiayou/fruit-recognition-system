import request from '@/utils/request'

// 查询user列表
export function listUser(query) {
  return request({
    url: '/utrain/user/list',
    method: 'get',
    params: query
  })
}

// 查询user详细
export function getUser(id) {
  return request({
    url: '/utrain/user/' + id,
    method: 'get'
  })
}

// 新增user
export function addUser(data) {
  return request({
    url: '/utrain/user',
    method: 'post',
    data: data
  })
}

// 修改user
export function updateUser(data) {
  return request({
    url: '/utrain/user',
    method: 'put',
    data: data
  })
}

// 删除user
export function delUser(id) {
  return request({
    url: '/utrain/user/' + id,
    method: 'delete'
  })
}
