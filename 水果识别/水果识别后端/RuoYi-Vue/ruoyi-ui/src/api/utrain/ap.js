import request from '@/utils/request'

// 查询ap列表
export function listAp(query) {
  return request({
    url: '/utrain/ap/list',
    method: 'get',
    params: query
  })
}

// 查询ap详细
export function getAp(id) {
  return request({
    url: '/utrain/ap/' + id,
    method: 'get'
  })
}

// 新增ap
export function addAp(data) {
  return request({
    url: '/utrain/ap',
    method: 'post',
    data: data
  })
}

// 修改ap
export function updateAp(data) {
  return request({
    url: '/utrain/ap',
    method: 'put',
    data: data
  })
}

// 删除ap
export function delAp(id) {
  return request({
    url: '/utrain/ap/' + id,
    method: 'delete'
  })
}
