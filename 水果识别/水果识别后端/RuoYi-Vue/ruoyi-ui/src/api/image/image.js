import request from '@/utils/request'

// 查询image列表
export function listImage(query) {
  return request({
    url: '/image/image/list',
    method: 'get',
    params: query
  })
}

// 查询image详细
export function getImage(id) {
  return request({
    url: '/image/image/' + id,
    method: 'get'
  })
}

// 新增image
export function addImage(data) {
  return request({
    url: '/image/image',
    method: 'post',
    data: data
  })
}

// 修改image
export function updateImage(data) {
  return request({
    url: '/image/image',
    method: 'put',
    data: data
  })
}

// 删除image
export function delImage(id) {
  return request({
    url: '/image/image/' + id,
    method: 'delete'
  })
}
